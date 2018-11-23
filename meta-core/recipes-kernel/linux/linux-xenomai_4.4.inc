inherit kernel
inherit xenomai
require recipes-kernel/linux/linux-yocto.inc

PACKAGECONFIG_append = " xenomai"

SRC_URI = "git://gitlab.denx.de/ipipe.git;nocheckout=1;name=machine;branch=ipipe-4.4.y"

LINUX_VERSION ?= "4.4.162"
LINUX_VERSION_EXTENSION_append = "-xenomai"

SRCREV = "636378006c813abfbba83066c01a6406bea66b27"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "(^$)"
