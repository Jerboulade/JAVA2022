import { FormControl, FormGroup, Validators } from "@angular/forms";

export function fWorkerCreate(): FormGroup {
    return new FormGroup({
        firstname: new FormControl(null, [Validators.required]),
        lastname: new FormControl(null, [Validators.required]),
        department: new FormControl(null)
    })
}

export function fWorkerLogin(): FormGroup {
  return new FormGroup({
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
  })
}
