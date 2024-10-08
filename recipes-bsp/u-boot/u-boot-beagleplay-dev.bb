require recipes-bsp/u-boot/u-boot-ti.inc

PR = "r0"

PV = "2024.10-rc1"

UBOOT_GIT_URI = "git://source.denx.de/u-boot/u-boot.git"
UBOOT_GIT_PROTOCOL = "https"
SRCREV = "123f6f75dfcb5f88d821e4eb91ddedfb7718d601"

SRC_URI += "file://extra-u-boot-configs.cfg"

do_create_tispl_bin_symlink() {
    if [ -e ${B}/tispl.bin_unsigned ]; then
        ln -sf ${B}/tispl.bin_unsigned ${B}/tispl.bin
    else
        echo "Source file does not exist: ${B}/tispl.bin_unsigned"
        exit 1
    fi
}

do_create_u_boot_elf_symlink() {
    if [ -e ${B}/u-boot ]; then
        ln -sf ${B}/u-boot ${B}/u-boot.elf
    else
        echo "Source file does not exist: ${B}/u-boot"
        exit 1
    fi
}

do_deploy:append(){
    if [ -e ${B}/u-boot.elf ]; then
        install -D -m 644 ${B}/u-boot.elf ${DEPLOYDIR}/u-boot.elf
    fi
}

addtask do_create_tispl_bin_symlink before do_install after do_compile
addtask do_create_u_boot_elf_symlink before do_install after do_compile
