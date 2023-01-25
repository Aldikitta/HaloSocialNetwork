package com.aldikitta.designsystem

import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "phone", device = "spec:width=411dp,height=891dp, dpi=480")
@Preview(name = "landscape", device = "spec:width=891dp,height=411dp, dpi=480")
@Preview(name = "foldable", device = "spec:width=673.5dp,height=841dp,dpi=480")
@Preview(name = "tablet", device = "spec:width=1280dp,height=800dp,dpi=480")
@Preview(name = "desktop", device = "spec:width=1920dp,height=1080dp,dpi=480")
annotation class DevicePreviews