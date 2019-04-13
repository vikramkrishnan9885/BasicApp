<HTML><HEAD><TITLE>A Colorful and Dynamic Table</TITLE></HEAD>
<BODY>
<CENTER>
 <H1>Colorful and Dynamic Table</H1>
<FORM METHOD=POST ACTION=dynamicTable.jsp>
Table Width  (<16) = <INPUT TYPE=TEXT NAME=WIDTH  VALUE=15 SIZE=2>,
Table Height (<16) = <INPUT TYPE=TEXT NAME=HEIGHT VALUE=5  SIZE=2>,
<INPUT TYPE=SUBMIT VALUE="Do it !">
</FORM>
<HR>
 <%  String w = request.getParameter("WIDTH");
     String h = request.getParameter("HEIGHT");
     if(w == null) w = "5";
     if(h == null) h = "15";
     int width  = Integer.parseInt(w);
     int height = Integer.parseInt(h);
     if(width>15)  width  = 15;
     if(width<0)   width  = 0;
     if(height>15) height = 15;
     if(height<0)  height = 0;
     String[] colorArray  = { "00", "11", "22", "33", "44", "55", "66", "77","88", "99", "AA", "BB","CC", "DD", "EE", "FF"  };  %>
 <TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0>
 <%  for(int y=0; y<=height; y++){    %>
         <TR>
 <%      for(int x=0; x<=width; x++){
            String bgColor = "AA" + colorArray[y] + colorArray[x];    %>
          <TD BGCOLOR=<%=bgColor%>>
           (<%=x%>, <%=y%>)
           </TD>
 <%      }                 %>
         </TR>
 <%  }       %>
 </TABLE>
<HR>
</CENTER>
</BODY></HTML>
