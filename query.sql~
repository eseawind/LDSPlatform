CREATE OR REPLACE PACKAGE BODY droid_document_pck IS

  PROCEDURE get_next_question(p_document_type IN VARCHAR2,
                              p_lev_1         IN NUMBER,
                              p_lev_2         IN NUMBER,
                              p_lev_3         IN NUMBER,
                              x_question_id   OUT NUMBER,
                              x_lev_1         OUT NUMBER,
                              x_lev_2         OUT NUMBER,
                              x_lev_3         OUT NUMBER,
                              x_question_text OUT VARCHAR2,
                              x_last_flag     OUT VARCHAR2) IS
  BEGIN
  
    x_last_flag := 'N';
  
    BEGIN
    
      SELECT question_id, level_1, level_2, level_3, question_text
        INTO x_question_id, x_lev_1, x_lev_2, x_lev_3, x_question_text
        FROM (SELECT hb.question_id, hb.level_1, hb.level_2, hb.level_3, hb.question_text
                FROM droid_question_bank hb
               WHERE hb.question_type = p_document_type
                 AND (hb.level_1 > p_lev_1 OR hb.level_2 > p_lev_2 OR
                     nvl(hb.level_3, 1) > nvl(p_lev_3, 0))
               ORDER BY hb.level_1, hb.level_2, hb.level_3)
       WHERE rownum = 1;
    
    EXCEPTION
      WHEN no_data_found THEN
        x_last_flag := 'Y';
    END;
  
    RETURN;
  
  EXCEPTION
    WHEN OTHERS THEN
      NULL;
    
  END;
END droid_document_pck;



