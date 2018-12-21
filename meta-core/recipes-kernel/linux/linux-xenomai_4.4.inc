inherit kernel
inherit xenomai
require recipes-kernel/linux/linux-yocto.inc

PACKAGECONFIG_append = " xenomai"

SRC_URI = "git://gitlab.denx.de/ipipe.git;nocheckout=1;name=machine;branch=ipipe-4.4.y-cip"

LINUX_VERSION ?= "4.4.166-cip29"
LINUX_VERSION_EXTENSION_append = "-xenomai"

SRCREV = "60a778a4a6aebf030d12c0eeab08ea9b060389b1"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "(^$)"
