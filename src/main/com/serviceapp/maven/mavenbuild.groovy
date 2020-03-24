package src.main.comserviceapp.maven

def createBuild(POM_PATH, MAVEN_VERSION, MVN_GOALS){
    try{
        sh "'${MAVEN_VERSION}'/bin/mvn -f '${POM_PATH}' ${MVN_GOALS}"
        print "[INFO]:successfully executing the build.."
   }
   catch(error){
       print "Build failed check the logs"
       throw error
   }
}