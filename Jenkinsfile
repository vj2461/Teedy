pipeline {
    agent any
    
    tools {
        maven 'Maven'
        jdk 'JDK11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('PMD Check') {
            steps {
                sh 'mvn pmd:pmd pmd:cpd'
            }
        }
        
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package JAR') {
            steps {
                sh 'mvn package'
            }
        }
        
        stage('Generate JavaDoc') {
            steps {
                sh 'mvn javadoc:javadoc'
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            archiveArtifacts artifacts: 'target/surefire-reports/**'
            archiveArtifacts artifacts: 'target/pmd.xml,target/cpd.xml'
            archiveArtifacts artifacts: 'target/site/apidocs/**'
        }
    }
}
