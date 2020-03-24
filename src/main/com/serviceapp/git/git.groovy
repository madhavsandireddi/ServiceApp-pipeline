package main.com.serviceapp.git

def gitCheckout{
    try{
          checkout changelog([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '887948f7-3739-41e7-bf8c-971977673050', url: 'https://github.com/madhavsandireddi/ServiceApp-pipeline.git']]])
          print "successfully  clonne thhe repository...validate the logs"
       }
    catch (error){
        print "Failed to clone the repository..please check the logs"
        throw error
    }
}