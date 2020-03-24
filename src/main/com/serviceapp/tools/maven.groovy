package main.com.serviceapp.tools

def setMavenHome(VERSION){
    try{
        env.MAVEN_HOME="${tool "${VERSION}"
        env.PATH="${env.MAVEN_HOME}/bin:${env.PATH}"
       }
    catch(error){
         print "Maven home path is not defined properly MAVEN_HOME"
         throw error
        }
}
