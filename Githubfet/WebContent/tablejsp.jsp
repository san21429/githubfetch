<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
td
{ text-align: center;
  margin:25px;

}
th
{ margin:25px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th>Total number of open issues</th>
<th>Number of open issues that were opened in the last 24 hours</th>
<th>Number of open issues that were opened more than 24 hours ago but less than 7 days ago</th>
<th>Number of open issues that were opened more than 7 days ago </th>
</tr>
<tr>
<td>${total} </td>
<td>${total24} </td>
<td>${total247} </td>

<td>${total7} </td>

</tr>
</table>

</body>
</html>