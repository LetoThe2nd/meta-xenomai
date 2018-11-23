require recipes-kernel/linux/linux-xenomai_4.4.inc

SRC_URI += "file://defconfig"

COMPATIBLE_MACHINE = "beaglebone-xenomai"
