inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p '\$1\$HhsG6ibe\$welFXCf1sirIa/p6eTmsO1' root;"
EXTRA_IMAGECMD:append = " -O ^metadata_csum"

IMAGE_FSTYPES += "ext4"
IMAGE_INSTALL:append = "packagegroup-core-ssh-openssh u-boot-env bash iiotest drmtest pong bmi270-mod sharp-mod"
