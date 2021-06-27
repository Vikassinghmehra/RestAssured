package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vikas Mehra
 * @date 26/06/21 3:43 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Doc {
        public void set_id(String _id) {
                this._id = _id;
        }

        public String get_id() {
                return _id;
        }

        public String _id;
        public String name;

}
