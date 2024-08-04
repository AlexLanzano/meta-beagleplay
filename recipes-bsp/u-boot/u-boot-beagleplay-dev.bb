require recipes-bsp/u-boot/u-boot-ti.inc

PR = "r0"

PV:beagleplay-dev-k3r5 = "2024.07"
PV = "2024.10-rc1"

SRC_URI:beagleplay-dev += "file://0001-update-bootcmd-beagleplay-dev.patch"

# For the un-initiated:
# The actual URL you'd use with a git clone for example would be:
# https://source.denx.de/u-boot/u-boot.git/
# However, in the context of OE, we have to explicitly split things up:
# a) we want it to use git fetcher - hence git:// prefix in GIT_URI (if we
#  used https here, we'd endup attempting wget instead of git)
# b) and we want git fetcher to use https protocol, hence GIT_PROTOCOL as https
UBOOT_GIT_URI = "git://source.denx.de/u-boot/u-boot.git"
UBOOT_GIT_PROTOCOL = "https"
SRCREV = "123f6f75dfcb5f88d821e4eb91ddedfb7718d601"
SRCREV:beagleplay-dev-k3r5 = "3f772959501c99fbe5aa0b22a36efe3478d1ae1c"
do_create_tispl_bin_symlink() {
    if [ -e ${B}/tispl.bin_unsigned ]; then
        ln -sf ${B}/tispl.bin_unsigned ${B}/tispl.bin
    else
        echo "Source file does not exist: ${B}/tispl.bin_unsigned"
        exit 1
    fi
}

addtask do_create_tispl_bin_symlink before do_install after do_compile
