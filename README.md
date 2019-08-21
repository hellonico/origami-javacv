# interesting javacv samples

http://bytedeco.org/news/2015/04/04/javacv-frame-converters/
https://github.com/bytedeco/javacv/blob/master/samples/ImageSegmentation.java

# Missing on the raspberry pi

```
apt install libgfortran3
```

# Jupyter 

```
pip install jupyter

# clojure jupyter setup

## install leiningen
## https://leiningen.org/#install
export LEIN_WORKING_DIRECTORY=$PWD
lein jupyter install-kernel

# java jupyter setup
# download: https://github.com/SpencerPark/IJava/releases
wget https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip
unzip  ijava-1.3.0.zip
# with pyenv change the prefix for the kernel
python3 install.py --prefix=/home/pi/.local

# make sure you are using java 8 for java (broken with later sdks ..)
sudo update-alternatives --set java /usr/lib/jvm/java-11-openjdk-armhf/bin/java
```

now check kernels are installed
```
pi@raspberrypi:~/Downloads $ jupyter kernelspec list 
Available kernels:
  java            /home/pi/.local/share/jupyter/kernels/java
  lein-clojure    /home/pi/.local/share/jupyter/kernels/lein-clojure
  python3         /home/pi/.local/share/jupyter/kernels/python3
```

```
# start notebook
jupyter notebook --ip=0.0.0.0


```