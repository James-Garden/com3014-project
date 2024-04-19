export interface ValidationFailedResponse {
  errors: ValidationError[]
}

export interface ValidationError {
  field: string,
  message: string
}

export interface GenericException {
  timestamp: string,
  status: number,
  error: string,
  path: string
}
