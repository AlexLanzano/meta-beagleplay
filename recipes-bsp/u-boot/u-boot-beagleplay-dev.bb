require recipes-bsp/u-boot/u-boot-ti.inc

PR = "r0"

PV = "2024.04"

SRC_URI += "file://0001-update-bootcmd-beagleplay-dev.patch"

# For the un-initiated:
# The actual URL you'd use with a git clone for example would be:
# https://source.denx.de/u-boot/u-boot.git/
# However, in the context of OE, we have to explicitly split things up:
# a) we want it to use git fetcher - hence git:// prefix in GIT_URI (if we
#  used https here, we'd endup attempting wget instead of git)
# b) and we want git fetcher to use https protocol, hence GIT_PROTOCOL as https
UBOOT_GIT_URI = "git://source.denx.de/u-boot/u-boot.git"
UBOOT_GIT_PROTOCOL = "https"
SRCREV = "25049ad560826f7dc1c4740883b0016014a59789"

do_create_tispl_bin_symlink() {
    if [ -e ${B}/tispl.bin_unsigned ]; then
        ln -sf ${B}/tispl.bin_unsigned ${B}/tispl.bin
    else
        echo "Source file does not exist: ${B}/tispl.bin_unsigned"
        exit 1
    fi
}

addtask do_create_tispl_bin_symlink before do_install after do_compile