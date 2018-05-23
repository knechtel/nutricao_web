# Portal Nutris (Web)

Web content of the Portal Nutris project.

Technologies used: CDI, JSF, EJB, Hibernate and Web server Wildfly 11

## How to set up:

1) Download latest version of Eclipse IDE for Java EE: https://www.eclipse.org/downloads/

2) Install plugin JBOSS tools:
On Eclipse, click on > Help > Eclipse Marketplace. Select the RedHat logo, search for JBoss Tools and install it.

<br>
<img src='https://1.bp.blogspot.com/-sUiJqolN5Rs/WqcovbiOgcI/AAAAAAAADII/2HZBLGhjnmk6pM2_GHvAleJ5lp_i0uf-wCLcBGAs/s320/jboss.png'/>
</br>

3) Switch to Java EE perspective

<br>
<img src='https://1.bp.blogspot.com/-9Xq2OyiRCLI/WqdkGV-bPVI/AAAAAAAADKE/cJ4XWCIFszUixf4oZEjueV3dZwieoWhVgCLcBGAs/s1600/jee.jpg'/>
</br>

4) In Project Explorer, right click and choose Import > Git > Project from Git and enter the repo information

<br>
<img src='https://1.bp.blogspot.com/-2gShJl41r3M/Wqcr_N6uQYI/AAAAAAAADIg/0FD5V-ibI3Ykb0o_NShAgWC_gBBmP51DwCLcBGAs/s1600/git.png'/>
</br>

5) Update Dependencies: Right click on the project > Maven > Update Project.

6) Configure web server: right click on the Project, select Run AS > Run on Server. Choose WildFly11 > Next

<br>
<img src='https://3.bp.blogspot.com/-IEa2mJ4U-N0/Wqcu1C6r0eI/AAAAAAAADI4/ZMdXzIrkPos5x-sKy1U8Ba9BFi7BA97GACLcBGAs/s1600/Screen%2BShot%2B2018-03-12%2Bat%2B22.51.27.png'/>
</br>

6.1) Enter the Home Directory for the Wildfly download, and click on "Download and Install runtime".

<br>
<img src='https://2.bp.blogspot.com/-np81tFjRKus/WqcxJ_UAsUI/AAAAAAAADJE/ndAgcGf4CTgq_fDXG5Bb1pFMCaXc0w9WQCLcBGAs/s1600/Screen%2BShot%2B2018-03-12%2Bat%2B23.01.32.png'/>
</br>

7) In a broswser, access http://localhost:8080/nutricao_web/index.xhtml

**Note:** the first admin user should be created directly in the database with password hashed using sha256. Example:
```
INSERT INTO `usuario` VALUES
(1,'email@domain.com','Admin','fbfb386efea67e816f2dda0a8c94a98eb203757aebb3f55f183755a192d44467',1,NULL)
```
