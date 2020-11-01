# WebHomework3
三、编程题

设计一个需要验证后才能使用的加法计算Servlet,具体要求如下：

1）设计实现一个addServlet，用来接收形求和请求，参数形如 a=1&b=1，addServlet对参数a、b是否有有效数字进行检查，当a、b值为有效数字时，将请求转发给doneServlet进行处理。

2）设计实现doneServlet,对接收到了两个参数a、b进行求和然后返回结果。

3）设计一个过滤器，对请求进行过滤，检查session中是否有登录成功标志，如果没有，则重定向到登录页面

4）设计一个登录页面，其中有表单用于输入用户名和密码，点击提交时表单将post到loginServlet上。

5）设计一个loginServlet,当请求参数为user=admin，password=123456时，认为登录成功，将登录成功标志位记录在session中。

6）设计一个logoutServlet，用来清除当前session中的登录成功标志

测试流程

1）首次请求url /addServlet?a=1, 由于未执行登录，则被重定向到登录页面

2）在登录页面输入用户名密码，当用户名密码正确时登录成功

3）再次请求url /addServlet?a=1，返回参数错误信息

4）请求url /addServlet?a=1&b=2，返回ab的和3（有doneServlet计算完成）

5）请求url /logoutServlet, 注销当前登录

6）请求url /addServlet?a=1&b=2，由于已注销，被重定向到登录页面
