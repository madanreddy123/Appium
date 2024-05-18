# Use an official Node.js image as the base image
FROM node:14

# Install necessary tools
RUN apt-get update && apt-get install -y wget unzip python3 openjdk-11-jdk

# Set environment variables for Android SDK
ENV ANDROID_HOME /opt/android-sdk
ENV ANDROID_SDK_ROOT /opt/android-sdk
ENV PATH ${PATH}:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools

# Install Android SDK command line tools
RUN mkdir -p ${ANDROID_HOME}/cmdline-tools && \
    cd ${ANDROID_HOME}/cmdline-tools && \
    wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip -O commandlinetools.zip && \
    unzip commandlinetools.zip -d ${ANDROID_HOME}/cmdline-tools && \
    mv ${ANDROID_HOME}/cmdline-tools/cmdline-tools ${ANDROID_HOME}/cmdline-tools/latest && \
    rm commandlinetools.zip

# Install Android SDK components
RUN yes | ${ANDROID_HOME}/cmdline-tools/latest/bin/sdkmanager --sdk_root=${ANDROID_HOME} "platform-tools" "platforms;android-30" "build-tools;30.0.3"

# Install Appium
RUN npm install -g appium

# Create directories for serving files and for Appium
RUN mkdir -p /shared /appium

# Copy the APK file into the container
COPY app.apk /shared/app.apk

# Copy the HTTP server script into the container
COPY simple_http_server.py /shared/simple_http_server.py

# Expose necessary ports
EXPOSE 4723 8000

# Start the HTTP server and Appium server
CMD ["sh", "-c", "python3 /shared/simple_http_server.py & appium --address 0.0.0.0 --port 4723"]