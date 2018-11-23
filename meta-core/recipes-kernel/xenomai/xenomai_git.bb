SUMMARY = "Xenomai 3 userspace libraries"
DESCRIPTION = "Xenomai 3 userspace libraries"
HOMEPAGE = "http://www.xenomai.org/"
SECTION = "libs"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://include/COPYING;md5=79ed705ccb9481bf9e7026b99f4e2b0e \
	file://kernel/cobalt/COPYING;md5=073dc31ccb2ebed70db54f1e8aeb4c33 \
	file://kernel/cobalt/posix/COPYING;md5=073dc31ccb2ebed70db54f1e8aeb4c33 \
	file://kernel/cobalt/rtdm/COPYING;md5=c99f6e66e37d1cb50ad8be4f5be2ea5d \
	file://lib/alchemy/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/analogy/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/boilerplate/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/cobalt/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/copperplate/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/psos/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/smokey/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/trank/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	file://lib/vxworks/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
	"

RDEPENDS_${PN} = "libgcc"

SRC_URI = "git://gitlab.denx.de/Xenomai/xenomai.git;protocol=https;branch=stable/v3.0.x"
SRCREV="9741e102e1b3b4cd45babe8f194a34b469fdc632"

S = "${TMPDIR}/work-shared/${MACHINE}/xenomai-source"
B = "${WORKDIR}/build"

inherit autotools pkgconfig

EXTRA_OECONF = "--includedir=${includedir}/${PN} --with-demodir=${bindir} --enable-smp"

do_unpack_extra() {
	rmdir ${S}
	mv ${WORKDIR}/git ${S}
}
addtask unpack_extra after do_unpack before do_patch

do_install_append() {
	rm -fR ${D}/dev
}

PACKAGES =+ "${PN}-bin ${PN}-demos"

FILES_${PN}-dev += "${libdir}/*.wrappers ${libdir}/dynlist.ld"
FILES_${PN}-bin = "/usr/bin/* /usr/sbin/*"
FILES_${PN}-demos = "/usr/demo/*"

RDEPENDS_${PN} += "bash"
