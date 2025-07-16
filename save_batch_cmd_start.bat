set projectLocation="C:\Users\ravi-skyselect\eclipse-workspace\skyselect_Maven"

cd %C:\Users\ravi-skyselect\eclipse-workspace\skyselect_Maven%

set classpath=%C:\Users\ravi-skyselect\eclipse-workspace\skyselect_Maven%\bin;%C:\Users\ravi-skyselect\eclipse-workspace\skyselect_Maven%\lib\*;

java org.testng.TestNG %C:\Users\ravi-skyselect\eclipse-workspace\skyselect_Maven\config%\testng.xml

pause