
             Software Architecture Assignment1 Project

  What is it?
  -------------------

  The Project is a prototype of concept to demonstrate that SaaS applications could 
  support the 5th level customization: Code Level. 
    Prepared for:    Dr. Roopak Sinha
    Prepared by:     LI, Mao Chuan; Sharma, Chandan; CHEN, Xiao Yu     
    Paper Name:      Software Architecture
    Paper Number:    COMP806
    Assignment Name: Assessment 1


  Git Access
  -------------------

  The project source repository is available via Git from the github.com server; 
  look here for details:

  https://github.com/AUT-MCIS-ORG/saas-on-osgi-main
  https://github.com/AUT-MCIS-ORG/saas-on-osgi-services

  Installation and Configuration
  -------------------

  The project is delivered as a zip file, unzipping the file into a directory is
  all for installation. 
  There is one build file “saas-on-osgi-build.sh” to build all the projects

  The application is based on OSGi and Jetty open source technologies, running it requires
  Java Development Kit and Maven build tool to build the projects. So the following global 
  environment variables need set:
  JAVA_HOME - the java development kit home directory
  MVN_HOME - the maven build tool home directory
  PATH - the path environment variable to include JAVA_HOME and MVN_HOME like:
  export PATH=$JAVA_HOME/bin:$MVN_HOME/bin:$PATH

  After setting the above 3 variables, just run the build script “saas-on-osgi-build.sh” and
  it will build the whole projects. 

  Execution
  -------------------
  The application can be run either locally or inside Heroku cloud platform. 
  Running locally can be simply to:
  $ cd saas-on-osgi-main/
  $ ./startLocalServer.sh

  To run the application in Heroku, please follow the guide: 
  https://devcenter.heroku.com/articles/getting-started-with-java#introduction
  
  Licensing
  ---------------------

  Please see the file called LICENSE.

  Notice
  -------------------
 
  All Mac OSX, Windows 2008, Debian operating systems are supported, but the script included
  are for Mac and Linux only. But they are very simply to adapt to Windows OS.  
    
  Troubleshooting
  -------------------

  For building the projects, directory names are dependant, please don’t rename them, and make 
  sure the saas-on-osgi-main and saas-on-osgi-services are under the same directory.
