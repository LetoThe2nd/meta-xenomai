inherit kernel
inherit xenomai
require recipes-kernel/linux/linux-yocto.inc

PACKAGECONFIG_append = " xenomai"

SRC_URI = "git://gitlab.denx.de/ipipe.git;nocheckout=1;name=machine;branch=ipipe-4.4.y-cip"

LINUX_VERSION ?= "4.4.176"
LINUX_VERSION_EXTENSION_append = "-xenomai"

SRCREV = "33f523bee3eba222ac67e9d27d783418f2408078"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "(^$)"
