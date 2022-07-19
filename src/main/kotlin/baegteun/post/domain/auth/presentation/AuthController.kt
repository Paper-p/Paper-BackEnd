package baegteun.post.domain.auth.presentation

import baegteun.post.domain.auth.presentation.dto.request.SignupRequestDto
import baegteun.post.domain.auth.services.SignupService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("auth")
class AuthController(
    private val signupService: SignupService
) {
    @PostMapping("signup")
    fun signup(@RequestBody @Valid signupRequestDto: SignupRequestDto): ResponseEntity<Void> = signupService.execute(signupRequestDto)
}