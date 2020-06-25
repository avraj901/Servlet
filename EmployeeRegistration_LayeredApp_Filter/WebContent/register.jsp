<h1 style="color:red;text-align: center">Employee Registrstion Layered Application</h1>

<form action="controller" method="post">
<table align="center" boredr="1" bgcolor="cyan">
<tr>
<td>Employee Name :: </td>
<td><input type="text" name="ename"></td>
</tr>
<tr>
<td>Employee Address :: </td>
<td><input type="text" name="eaddress"></td>
</tr>
<tr>
<td>Date of Joining :: </td>
<td><input type="date" name="doj"></td>
</tr>
<tr>
<td>Employee BasicSalry :: </td>
<td><input tpye="text" name="basicSalary"></td>
<tr>
<tr>
</tr>
<tr><td colspan="2"><input type="hidden" name="clientToken" value="${serverToken}"></td></tr>
<tr>
<td><input type="submit" vlaue="register"></td>
<td><input type="reset" value="cancel">
</tr>

</table>
</form>
Request count :: ${reqCount}