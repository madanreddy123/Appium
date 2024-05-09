# Appium

clone the project into your local directory https://github.com/appium/appium-docker-android.git

# run the terminal from the IntelliJ 

# build all the tools required on the docker container 
docker build -t "appium/appium:local" -f Appium/Dockerfile Appium
# run the docker command to run the run the Appium server 
docker run --privileged -d -p 4723:4723 --device=/dev/<your-device-id> --name appium-container appium/appium
 
# next connect your device to the machine

# check if the device is properly accessed by the command 

adb devices

# then run the code with the capabilities 


