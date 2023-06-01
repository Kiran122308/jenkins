pipeline {
    agent {
        kubernetes {
            label 'jenkins' //Pointing to the POD template label in the UI, If not specified a new pod template will be created with job name.
            yaml '''
apiVersion: v1
kind: Pod
metadata:
  labels:
    app: jenkins
spec:
  containers:
  - name: jnlp
    image: jenkins/inbound-agent:3107.v665000b_51092-5
    resources:
      limits:
        cpu: '1'
        memory: '1Gi'
      requests:
        cpu: '0.5'
        memory: '512Mi'
'''
        }
    }
    stages {
        stage('Main') {
            steps {
                echo 'hostname'
            }
        }
    }
}
