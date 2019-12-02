# Use JavaCV on a raspberry pi

Original goal was to check the difference of speed between standard compiled OpenCV (so origami) and JavaCV.
I also originally thought JavaCV was compiling OpenCV with Gpu bindings, **it is not**.


# more relevant javacv samples

http://bytedeco.org/news/2015/04/04/javacv-frame-converters/
https://github.com/bytedeco/javacv/blob/master/samples/ImageSegmentation.java

# Installation.

# extra libraries missing on modern raspbian ...

Things that were missing on the raspberry pi

```
apt install libgfortran3
```

# Jupyter notebook integgration for both clojure and java

```
pip install jupyter
```

## extra clojure jupyter setup

```
## install leiningen
## https://leiningen.org/#install

lein jupyter install-kernel
```

##  extra java jupyter setup

```
# download: https://github.com/SpencerPark/IJava/releases
wget https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip
unzip  ijava-1.3.0.zip
# with pyenv change the prefix for the kernel
python3 install.py --prefix=/home/pi/.local

# make sure you are using java 8 for java (broken with later sdks ..)
sudo update-alternatives --set java /usr/lib/jvm/java-8-openjdk-armhf/bin/java

# Although this seems to work ?
sudo update-alternatives --set java /usr/lib/jvm/java-11-openjdk-armhf/bin/java
```


now check the java and clojure kernels are installed:

```
pi@raspberrypi:~/Downloads $ jupyter kernelspec list 
Available kernels:
  java            /home/pi/.local/share/jupyter/kernels/java
  lein-clojure    /home/pi/.local/share/jupyter/kernels/lein-clojure
  python3         /home/pi/.local/share/jupyter/kernels/python3
```

```
# start the notebook on a given ip
export LEIN_WORKING_DIRECTORY=$PWD
jupyter notebook --ip=0.0.0.0
```