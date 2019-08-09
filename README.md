# SpringBootResutfulDemo
### 包含了数据库MySQL增删查改 CRUD

这是Resutful接口常用格式

带有 Resutful接口 请求的时候 需要 转为 Json带参数

运用POSTMAN 请求

http://192.168.0.135:8080/user/editUser  

请求方式 Post

Header 需要修改为 Content-type:application/json 

参数形式 Body {"userid":"1","email":"278161009@qq.com","usercode":"abcdefdjajdk1111111","sex":"man"}

使用 MyBatis xml方式写sql语句 以前项目使用的都是 用注解的方式 项目中也可以同时使用 注解和xml形式复杂的查询选择xml比较方便

项目包含配置好的日志Log4j

Mapper代码
'''
 @Mapper
public interface UserMapper {
    /**
     * 获取账号和密码
     * @param email
     * @param password
     * @return UserModel
     */
    UserModel getUser(String email,String password);


    /**
     * 添加用户的接口
     * @param params
     * @return number
     */
    int addUser(Map<String,Object> params);


    /**
     * 查询用户是否存在相同的用户名
     * @param email
     * @return UserModel
     */
    UserModel queryUser(@Param("email") String email);


    /**
     * 更新用户信息
     * @param user
     * @return number
     */
    int updateUser(UserModel user);


    /**
     * 删除用户信息
     * @param userid
     * @return number
     */
    int deleteUser(@Param("userid") Integer userid);
}

'''
 

Controller部分代码

'''
 @Controller
 @RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/user"})
 public class UserController extends BaseController{
     @Autowired
     private UserService userService;

     //信息打印Log4j
     private static final Logger logger = LoggerFactory.getLogger(UserController.class);

     /**
      * 得到用户信息
      * 只能通过Post接收传递的数据
      * ResponseBody是用于构建RESTFUL api的
      */
     @RequestMapping(value = {"/getUser"}, method = {RequestMethod.POST})
     @ResponseBody
     public BaseResp<UserModel> getUser(@RequestBody GetUserReq req){
         BaseResp resp = new BaseResp();
         try{
             String email = req.getEmail();
             String password = req.getPassword();

             //检查不能为空值 空值就为错误
             if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
                 resp.setCode(StatusCode.Code.CODE_ERROR);
                 resp.setMessage("输入不能为空");
                 return resp;
             }

             String md5Pwd = MD5Util.MD5EncodeUtf8(password);
             UserModel user = userService.getUser(email, md5Pwd);

             if(user==null){
                 resp.setCode(StatusCode.Code.CODE_ERROR);
                 resp.setMessage("帐号或者密码错误");
                 return resp;
             }

             resp.setCode(StatusCode.Code.CODE_SUCCESS);
             resp.setMessage("获取成功");
             resp.setData(user);
             return resp;


         }catch (Exception e){
             return getBaseResp(logger,resp, e);
         }
     }
  }
'''



项目使用MyBatis xml如下：

'''
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.ril.rilcompany.mapper.UserMapper">
  
    <sql id="USER_TABLE">
        user_tb
    </sql>
  
    <sql id="USER_COLUMN">
        userid,email,password,usercode,username,sex,isadmin
    </sql>

    <!--logUser-->
    <select id="getUser" resultType="com.ril.rilcompany.model.UserModel">
        SELECT
        <include refid="USER_COLUMN"/>
        FROM
        <include refid="USER_TABLE"/>
       <where>
            <if test="email!=null">
              AND email = #{email, jdbcType=VARCHAR}
            </if>
            <if test="password!=null">
              AND password = #{password, jdbcType=VARCHAR}
            </if>
        </where>
    </select>

    <!--addUser-->
    <insert id="addUser" parameterType="map">
        INSERT INTO
        <include refid="USER_TABLE"/>
        <trim prefix="(" suffix=")" suffixOverrides=",">
            usercode,email,password,username
        </trim>
        <trim prefix="VALUES(" suffix=")" suffixOverrides=",">
            #{usercode,jdbcType=VARCHAR},#{email,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR},#{username,jdbcType=VARCHAR}
        </trim>
    </insert>


    <!--queryUser-->
    <select id="queryUser" resultType="com.ril.rilcompany.model.UserModel">
        SELECT
        <include refid="USER_COLUMN"/>
        FROM
        <include refid="USER_TABLE"/>
        <where>
            <if test="email!=null">
                AND email = #{email, jdbcType=VARCHAR}
            </if>
        </where>
    </select>


    <!--editUser-->
    <update id="updateUser" parameterType="com.ril.rilcompany.model.UserModel">
        UPDATE
        <include refid="USER_TABLE"/>
        <set>
            <if test="usercode != null">
                usercode = #{usercode,jdbcType=VARCHAR},
            </if>

            <if test="email != null">
                email = #{email,jdbcType=VARCHAR},
            </if>

            <if test="password != null">
                password = #{password,jdbcType=VARCHAR},
            </if>

            <if test="username != null">
                username = #{username,jdbcType=VARCHAR},
            </if>

            <if test="sex != null">
                sex = #{sex,jdbcType=VARCHAR},
            </if>

            <if test="isadmin != null">
                isadmin = #{isadmin,jdbcType=INTEGER},
            </if>
        </set>
        WHERE
        <if test="userid != null">
            userid = #{userid,jdbcType=INTEGER}
        </if>
    </update>


    <!--deleteUser-->
    <delete id="deleteUser">
        DELETE FROM
        <include refid="USER_TABLE"/>
        WHERE
        userid = #{userid,jdbcType=INTEGER}
    </delete>
</mapper>

'''




