<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <s:form action="addRepository" method="post">
        <s:select name="selectRepository"
                  id="selectRepository"
                  label="Select"
                  list="repositoryNames"
                  headerKey="-1"
                  headerValue="Select Repository" />
    </s:form>

</section>


<script type="text/javascript">
    $(document).ready(function() {
        $('#selectRepository').selectize({
            create: true,
            createOnBlur: true,
            highlight: true,
        });
        $("#selectRepository").change(function() {
            var selectedRepo = $("#selectRepository").val();
            if (!selectedRepo || selctedRepo == -1)
                return false;

            $.ajax({
                data: {
                    selectRepository: selectedRepo,
                },
                url: "/addRepository",
                success: function(result, status, xhr) {
                    // TODO -- note that the selected repository has changed
                    alert(selectedRepo);
                    // parse string as json object.
                    //var obj = JSON.parse(result);
                    //$("#userName").val(obj.userName)
                    //$("#name").val(obj.name)
                    //$("#email").val(obj.email)
                    //$("#deactivated").prop("checked", (obj.deactivated))
                }
            });
        });
    });
</script>
