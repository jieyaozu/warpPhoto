LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Hello
LOCAL_SRC_FILES := warpphoto.c
APP_ABI := all
LOCAL_LDLIBS += -llog

include $(BUILD_SHARED_LIBRARY)