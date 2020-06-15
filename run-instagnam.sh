#!/bin/bash
echo "    ____ _   __ _____ ______ ___    ______ _   __ ___     __  ___\n   /  _// | / // ___//_  __//   |  / ____// | / //   |   /  |/  /\n   / / /  |/ / \__ \  / /  / /| | / / __ /  |/ // /| |  / /|_/ / \n _/ / / /|  / ___/ / / /  / ___ |/ /_/ // /|  // ___ | / /  / /  \n/___//_/ |_/ /____/ /_/  /_/  |_|\____//_/ |_//_/  |_|/_/  /_/\n----------------------------------------------------------------"


echo Gradle build...
gradle build
echo DONE

echo Docker compose build...
docker-compose -f docker-compose.yml build
echo DONE

echo Docker compose up...
docker-compose up -d 
echo DONE
echo "   _____ ______ ___     ____  ______ ______ ____ \n  / ___//_  __//   |   / __ \/_  __// ____// __ \ \n  \__ \  / /  / /| |  / /_/ / / /  / __/  / / / /\n ___/ / / /  / ___ | / _, _/ / /  / /___ / /_/ / \n/____/ /_/  /_/  |_|/_/ |_| /_/  /_____//_____/  \n----------------------------------------------"





