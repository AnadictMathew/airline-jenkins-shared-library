def call(String accountId, String region, String repoName, String imageTag) {
    def ecrUrl = "${accountId}.dkr.ecr.${region}.amazonaws.com/${repoName}"

    sh """
        aws ecr get-login-password --region ${region} | \
        docker login --username AWS --password-stdin ${accountId}.dkr.ecr.${region}.amazonaws.com

        docker tag ${repoName}:${imageTag} ${ecrUrl}:${imageTag}
        docker push ${ecrUrl}:${imageTag}
    """
}