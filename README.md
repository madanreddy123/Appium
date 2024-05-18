# Appium

clone the project into your local directory https://github.com/appium/appium-docker-android.git

# run the terminal from the IntelliJ 

# build all the tools required on the docker container 
docker build -t "appium/appium:local" -f Appium/Dockerfile Appium
# run the docker command to run the run the Appium server 
docker run --privileged -d -p 4723:4723  -v /dev/bus/usb:/dev/bus/usb --name appium-container appium/appium

# next connect your device to the machine

# check if the device is properly accessed by the command 

adb devices

# then run the code with the capabilities 

# to connect wireless device containing the same network 
docker run --privileged -d -p 4723:4723  -e APPIUM_DEVICE_UDID=<ip address of the real device > --name appium-container appium/appium

docker run --privileged -d -p 4723:4723  -v /dev/bus/usb:/dev/bus/usb --name appium-container appium/appium

docker run -d -p 4723:4723 -p 8000:8000 --name appium-server apk-container


appium driver install uiautomator2

appium plugin install execute-driver

docker cp app.apk:/shared/files/app.apk

