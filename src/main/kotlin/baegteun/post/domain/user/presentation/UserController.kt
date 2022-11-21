package baegteun.post.domain.user.presentation

import baegteun.post.domain.user.presentation.dto.request.UpdateProfileImageRequestDto
import baegteun.post.domain.user.presentation.dto.response.MyMiniProfileResponseDto
import baegteun.post.domain.user.presentation.dto.response.UserProfileResponseDto
import baegteun.post.domain.user.services.FetchMyMiniProfileService
import baegteun.post.domain.user.services.FetchUserProfileService
import baegteun.post.domain.user.services.UpdateProfileImageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("user")
class UserController(
    private val updateProfileImageService: UpdateProfileImageService,
    private val fetchUserProfileService: FetchUserProfileService,
    private val fetchMyMiniProfileService: FetchMyMiniProfileService
) {

    @GetMapping("profile")
    fun fetchMyMiniProfile(): ResponseEntity<MyMiniProfileResponseDto> =
        fetchMyMiniProfileService.execute()

    @PutMapping
    fun updateProfileImage(@Valid @RequestBody updateProfileImageRequestDto: UpdateProfileImageRequestDto): ResponseEntity<Void> =
        updateProfileImageService.execute(updateProfileImageRequestDto)

    @GetMapping("{nickname}")
    fun fetchUserProfile(@NotBlank @PathVariable("nickname") nickname: String): ResponseEntity<UserProfileResponseDto> =
        fetchUserProfileService.execute(nickname)
}