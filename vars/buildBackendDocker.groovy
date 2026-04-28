def call(String backendDir, String repoName, String imageTag) {
    sh """
        docker build -t ${repoName}:${imageTag} ./${backendDir}
    """
}