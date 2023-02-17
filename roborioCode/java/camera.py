from cscore import CameraServer
import cv2
import numpy as np

width = 320
height = 240


CameraServer.enableLogging()

camera = CameraServer.startAutomaticCapture(dev=0, name="cam0")
camera.setResolution(width, height)


camera2 = CameraServer.startAutomaticCapture(dev=2, name="cam1")
camera2.setResolution(width, height)

cs1 = CameraServer.getVideo(name="cam0")
cs2 = CameraServer.getVideo(name="cam1")

while True:
    
    img = np.zeros(shape=(height, width, 3), dtype=np.uint8)
    img2 = np.zeros(shape=(height, width, 3), dtype=np.uint8)
    frame = cs1.grabFrame(image=img)
    frame2 = cs2.grabFrame(image=img2)
    if frame is None or frame2 is None:
        continue
    
    # create opencv stream to pass to dashboard
    img = frame[1]
    img2 = frame2[1]

    # put text on image
    cv2.putText(img, "cam0", (10, 20), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (255, 255, 255), 1)
    cv2.putText(img2, "cam1", (10, 20), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (255, 255, 255), 1)

    # put image on dashboard
    vout1 = CameraServer.putVideo("cam0", width, height)
    vout1.putFrame(img)
    vout2 = CameraServer.putVideo("cam1", width, height)
    vout2.putFrame(img2)