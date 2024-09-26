DESCRIPTION = "Add custom files to the rootfs"
SECTION = "support"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://update-u-boot.sh"

S = "${WORKDIR}"

RDEPENDS:${PN} += "bash"

FILES:${PN} += "/opt/u-boot/update-u-boot.sh"

do_install() {
    install -d ${D}/opt/u-boot
    install -m 0755 ${WORKDIR}/update-u-boot.sh ${D}/opt/u-boot/update-u-boot.sh
}
