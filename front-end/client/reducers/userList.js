import {
  USERLIST,
  REMOVESUBJECT,
  ADDSUBPRE,
  REMOVESUBPRE,
  USERCHANGE,
  DELETEUSER,
  ADDNEWSUBPRE,
  REMOVENEWSUBPRE,
  CREATEUSER,
  CLEAR
} from '../actions/actionCreators';

function userList(state={old: [], new: {
    username: '',
    password: '',
    subjects: []
  },
  delete: ''}, action) {
  switch (action.type) {
    case USERLIST:
      return {
        ...state,
        old: [
          ...action.posts
        ]
      };
    case REMOVESUBJECT:
      return {
        ...state,
        old: [
          ...state.old.slice(0, action.details.k),
          {
            ...state.old[action.details.k],
            subjectcan: action.details.subjectcan
          },
          ...state.old.slice(action.details.k + 1)
        ]
      };
    case ADDSUBPRE:
      return {
        ...state,
        old: [
          ...state.old.slice(0, action.details.i),
          {
            ...state.old[action.details.i],
            add: [
              ...state.old[action.details.i].add,
              action.details.subid
            ]
          },
          ...state.old.slice(action.details.i + 1)
        ]
      };
    case REMOVESUBPRE:
      return {
        ...state,
        old: [
          ...state.old.slice(0, action.details.i),
          {
            ...state.old[action.details.i],
            add: [
              ...state.old[action.details.i].add.slice(0, action.details.k),
              ...state.old[action.details.i].add.slice(action.details.k + 1)
            ]
          },
          ...state.old.slice(action.details.i + 1)
        ]
      };
    case USERCHANGE:
      return {
        ...state,
        old: [
          ...state.old.slice(0, action.details.k),
          {
            ...action.details.user
          },
          ...state.old.slice(action.details.k + 1)
        ]
      };
    case DELETEUSER:
      return {
        ...state,
        old: [
          ...state.old.slice(0, action.details.k),
          ...state.old.slice(action.details.k + 1)
        ],
        delete: action.details.username
      };
    case ADDNEWSUBPRE:
     return {
      ...state,
      new: {
        ...state.new,
        subjects: [
          ...state.new.subjects,
          action.details.subid
        ]
      }
    };
    case REMOVENEWSUBPRE:
      return {
        ...state,
        new: {
          ...state.new,
          subjects: [
            ...state.new.subjects.slice(0, action.details.k),
            ...state.new.subjects.slice(action.details.k + 1)
          ]
        }
      };
    case CREATEUSER:
      return {
        old: [
          ...state.old,
          action.details
        ],
        new: {
          username: '',
          password: '',
          subjects: []
        },
        delete: ''
      };
    case CLEAR:
      return {
        ...state,
        delete: ''
      }
    default:
      return state;
  }
}

export default userList;