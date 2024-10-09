inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p '\$1\$HhsG6ibe\$welFXCf1sirIa/p6eTmsO1' root; \
                      useradd -p '\$1\$DjqgEMjx\$EgUhNo7VRCWgI9nyuwqxG/' -G sudo -d /home/beagle -m beagle;"

EXTRA_IMAGECMD:append = " -O ^metadata_csum"

IMAGE_FSTYPES += "ext4"
IMAGE_INSTALL:append = "packagegroup-core-ssh-openssh u-boot-env bash mmc-utils util-linux vim sudo u-boot-utils"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://beagle-sudo"

# S = "${WORKDIR}"

# FILES:${PN} += "/etc/sudoers.d/beagle-sudo"

# do_install:append() {
#     install -d ${D}/etc/sudoers.d
#     install -m 0440 ${WORKDIR}/beagle-sudo ${D}/etc/sudoers.d/beagle-sudo
# }
