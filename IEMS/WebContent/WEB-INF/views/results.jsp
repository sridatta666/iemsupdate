
<%@ page language="java" import="java.sql.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
        <link rel="stylesheet" href="css/displaytag.css" type="text/css">
        <link rel="stylesheet" href="css/screen.css" type="text/css">
        <link rel="stylesheet" href="css/site.css" type="text/css">
       
        
        <style>
             {padding:0; margin:0;}

            html {
                padding:15px 15px 0;
                font-family:sans-serif;
                font-size:14px;
            }

            p, h3 {
                margin-bottom:15px;
            }

            div {
                padding:10px;
                width:600px;
                background:#fff;
            }

            .tabss li {
                list-style:none;
                display:inline;
            }

            .tabss a {
                padding:5px 10px;
                display:inline-block;
                background:#666;
                color:#fff;
                text-decoration:none;
            }

            .tabss li.active a{
                background:#f0f;
                color:#00;
            }
           
            .tab_content {
                display: none;
            }
        </style>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
         </script>
       
        <script>

         // Wait until the DOM has loaded before querying the document
         $(document).ready(function(){

            //Active tab selection after page load       
            $('#tabs').each(function(){
           
            // For each set of tabs, we want to keep track of
            // which tab is active and it's associated content
            var $active, $content, $links = $(this).find('a');
           
            // If the location.hash matches one of the links, use that as the active tab.
            // If no match is found, use the first link as the initial active tab.
            $active = $($links.filter('[href="'+location.hash+'"]')[0]
                      || $links[0]);
            
            $active.parent().addClass('active');
           
            $content = $($active.attr('href'));
            $content.show();
        });
       
       
         $("#tabs li").click(function() {
                
             // First remove class "active" from currently active tab
             $("#tabs li").removeClass('active');
        
             // Now add class "active" to the selected/clicked tab
             $(this).addClass("active");
                
             // Hide all tab content
             $(".tab_content").hide();

             // Here we get the href value of the selected tab
             var selected_tab = $(this).find("a").attr("href");      

             var starting = selected_tab.indexOf("#");
             var sub = selected_tab.substring(starting);
               
             //write active tab into cookie
                
             //$(sub).show();
                 $(sub).fadeIn();
             // At the end, we add return false so that the click on the
            // link is not executed
             return false;
          });
        });

       </script>
		
</head>

<body bgcolor="mezanta">
<table align="right">
<td><h5><i>Welcome <%= session.getAttribute("name") %></i></h5></td>
<td>
<a href="logout" >Logout</a>|</td>
<td>
<a href="changePassword">Change Password</a>|</td>
<td>
<a href="help" >Help</a>|
</td>
</table>
       
        <ul id='tabs' class="tabss">
			<li class='active'>
				<a href='#Profile'>Profile</a>
			</li>
			
            <li>
            <a href='#AddEmployee'>Add Employee</a>
            </li>
            
            <li>
            <a href='#Skills'>Skills</a>
            </li>
            
            <li>
            <a href='#Department'>Department</a>
            </li>
            
            <li>
            <a href='#Designation'>Designation</a>
            </li>
            
            <li>
            <a href='#Search'>Search</a>
            </li>
        </ul>        
     
        
        <div id='Profile' class="tab_content active">        
                <script>                              
                  $('#Profile').load('profile');
                </script>
        </div>             
             
        <div id='AddEmployee' class="tab_content hide">
                <script>                              
                  $('#AddEmployee').load('AddEmployee');
                </script>
        </div>          
       
        <div id='Skills' class="tab_content hide">
                <script>                              
                   $('#Skills').load('Skill');
                </script>
        </div>
 
        <div id='Department' class="tab_content hide">
                <script>                              
                   $('#Department').load('Department');
                </script>
 
        </div>   
       
        <div id='Designation' class="tab_content hide">
                <script>                             
                   $('#Designation').load('Designation');
                </script>
 
        </div>   
        
        <div id='Search' class="tab_content hide">
                <script>                           
                   $('#Search').load('Search');
                </script>
        </div>   
       
    </body>
    
</html>



