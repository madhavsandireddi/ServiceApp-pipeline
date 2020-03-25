#!/bin/groovy

import main.com.serviceapp.build.*
import main.com.serviceapp.tools.*
import main.com.serviceapp.git.*

def call(body)
{
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    timestamps {
        def g = new git()
        def cret = new mavenBuild()
        def java = new jdk()
        def m2 = new maven()

    stage ('Install all Devops Tools'){
    try{
            wrap([$class: 'AnsicolorBuildWrapper']){
            def version = "JDK1.8"
            java.setJavaHome("${VERSION}")
            }
    }
    catch (error)
    {
           wrap([$class: 'AnsicolorBuildWrapper']){
               echo "JAVA initializing failed.."
               throw error
           }
    }
    }    
    try{
            wrap([$class: 'AnsicolorBuildWrapper']) {
            def version = "Maven3"
            m2.setMavenHome("${VERSION}")
            }
    }
    catch (error)
    {
            wrap([$class: 'AnsicolorBuildWrapper']){
               echo "Maven initializing failed.."
               throw error
    }
    }
    stage ('checkout from the sourcecode git'){
    try{
        g.gitCheckout()
        echo "[SUCCESS] source code successfully downloade"
    }
    catch (Exception error){
        wrap([$class: 'AnsicolorBuildWrapper']) {
            print "[INFO]: ${error}"
            throw error
    }
    }     
    }
    stage ('Building the source code'){
        try{
              def MVN_GOALS = "clean compile install"
              def POM_PATH = "${WORKSPACE}/sm-shop/pom.xml"
              cret.createmavenBuild("${POM_PATH}", "${MAVEN_VERSION}", "${MVN_GOALS}")
        }
        catch (Exception error){
            wrap([$class: 'AnsicolorBuildWrapper']) {
            print "[INFO]: ${error}"
            throw error
        }
    }
    }
    }
}