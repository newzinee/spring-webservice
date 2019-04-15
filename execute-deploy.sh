# CodeDeploy에서 바로 deploy.sh를 실행시킬 수 없어, 우회하는 방법으로 deploy.sh를 실행하는 execute-deploy.sh 파일

#!/bin/bash
/home/ec2-user/app/travis/deploy.sh > /dev/null 2> /dev/null < /dev/null &