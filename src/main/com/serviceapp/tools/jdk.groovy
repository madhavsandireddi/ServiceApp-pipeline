package main.com.serviceapp.tools

def setJavaHome(VERSION){
    try{
        env.JAVA_HOME="${tool "{VERSION}"}"
        env.PATH="{env.JAVA_HOME}/bin:${env.PATH}"
    }
    catch (error){
        print "Failed to set JAVA_HOME"
        throw error
    }
}