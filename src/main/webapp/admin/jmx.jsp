<html>
    <body>
<%@ page import="javax.management.*,java.util.*" %>
<%
    try {
        //Step 1 - Get MBean server reference
        ArrayList servers = MBeanServerFactory.findMBeanServer(null);
        if (servers == null)
          throw new Exception("No MBeanServer found.");
        MBeanServer server = (MBeanServer)servers.get(0);
        //Step 2 - Create object to identify MBean
        ObjectName objName = new
        ObjectName("DefaultDomain:service=Logging,type=File");
        //Step 3 - Update MBean with new log file name
        String newvalue = (String)request.getParameter("LogName");
        if (newvalue != null && newvalue.length() > 0) {
            Attribute attr = new Attribute("LogName", newvalue);
            server.setAttribute( objName, attr );
        }
        //Step 4 - Get latest log name attribute
        String value = (String)server.getAttribute( objName,
                       "LogName");
%>

MBean     <%= objName.getCanonicalName() %>

<FORM METHOD="post" ACTION="jmx.jsp">
  <TABLE ALIGN="left" BORDER="1" WIDTH="40%" CELLPADDING="3">
    <TR>
      <TH WIDTH="23%"> Attribute </TH><TH WIDTH="35%"> Value </TH>
    </TR>
    <TR>
      <TD><B>LogName</B></A></TD>
      <TD><INPUT TYPE="text" NAME="LogName" VALUE="<%= value %>" SIZE="34%"></TD>
    </TR>
    <TR>
      <TD ALIGN=LEFT><INPUT TYPE="submit" VALUE="UPDATE"></TD>
    </TR>
  </TABLE>
</FORM>
<%
       } catch (Exception e) {
           out.println(e.getMessage());
       }
%>
</body>
</html>