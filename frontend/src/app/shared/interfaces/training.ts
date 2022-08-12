import {LearningRoute} from "./learning-route";

export interface Training {
  id: string,
  name: string;
  description: string;
  startDate: Date;
  endDate: Date;
  coach: string;
  routeLearning: LearningRoute;
  apprentices: Array<object>;
}
