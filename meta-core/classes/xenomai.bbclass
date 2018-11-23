PACKAGECONFIG[xenomai] = ",,"

do_patch_xenomai[depends] += "${@bb.utils.contains('PACKAGECONFIG', 'xenomai', 'xenomai:do_patch', '', d)}"
do_patch_xenomai() {
	set +e
	cd ${S}

	if [ "${@bb.utils.contains('PACKAGECONFIG', 'xenomai', 'yes', 'no', d)}" = "yes" ]; then
		${TMPDIR}/work-shared/${MACHINE}/xenomai-source/scripts/prepare-kernel.sh \
			--arch=${TARGET_ARCH} \
			--linux=${STAGING_KERNEL_DIR} ;
	fi
}

addtask patch_xenomai before do_configure after do_patch
