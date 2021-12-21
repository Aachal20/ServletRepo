<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"%>
<b> Add::${10+20}</b>
<br>
4 lessthan 5 ? ${ 4<5}
<br>
4 lessthan 5 ? ${4 lt 5}
<br>
4 greaterthan 5 ? ${4 gt 5}
<br>
4 greaterhan 5 ? ${4>5}
<br>
4 equals to 5 ? ${4 ==5}
<br>
4 equals to 5 ? ${4 eq 5}
<br>
<br>
Cookie name :: ${cookie.JSESSIONID.name}
<br>
Cookie Value(session id) :: ${cookie.JSESSIONID.value}
<br>
<hr>
context param db user value :: ${initParam.dbuser}
<br>
context param db pwd value :: ${initParam.dbpwd}
<br>
<hr>
<b>uname req param value :: ${param.uname}</b>
<br>
<b>addrs req param value ::
	${paramValues.addrs[0]},${paramValues.addrs[1]}</b>
<br>
<hr>
<b>user-agent request header value :: ${header['user-agent']}</b>
<br>
<br>
<b>user-agent request header value ::
	${headerValues['accept'][0]},${headerValues['accept'][1]}</b>
<br>


