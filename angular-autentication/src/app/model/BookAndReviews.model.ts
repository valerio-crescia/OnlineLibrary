import {Book} from "./Book.model";
import {Review} from "./Review.model";

export interface BookAndReviews {
  book: Book,
  reviews: Array<Review>
}
