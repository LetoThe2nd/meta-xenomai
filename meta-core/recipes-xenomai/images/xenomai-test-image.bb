SUMMARY = "A console-only image that supports xenomai testing tasks"

IMAGE_FEATURES += "read-only-rootfs"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL += " \
	kernel-modules \
	ltp \
	screen \
	xenomai-bin \
"

LICENSE = "MIT"

IMAGE_LINGUAS = " "

inherit core-image
